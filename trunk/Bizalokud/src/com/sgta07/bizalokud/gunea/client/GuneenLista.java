package com.sgta07.bizalokud.gunea.client;

import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.IntegerFieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.ObjectFieldDef;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;

public class GuneenLista extends GridPanel {

	private Store store;

	private ArrayReader reader;
	
	public GuneenLista() {
		super();
		setFrame(true);
		setStripeRows(true);

//		setGuneak(obj);
		
		RecordDef recordDef = new RecordDef(new FieldDef[] {
				new IntegerFieldDef("id"), new StringFieldDef("izena"),
				new StringFieldDef("helbidea"), new ObjectFieldDef("lat"), new ObjectFieldDef("lon")});

		MemoryProxy proxy = new MemoryProxy(new Object[0][]);
		
		reader = new ArrayReader(recordDef);
		store = new Store(proxy, reader);
		store.load();

		setStore(store);

		ColumnConfig[] columns = new ColumnConfig[] {
				new ColumnConfig("Gunea", "izena", 200, true, null, "izena"),
				new ColumnConfig("Helbidea", "helbidea", 200, true, null,
						"helbidea") };
		
		ColumnModel columnModel = new ColumnModel(columns);
		setColumnModel(columnModel);
		
		setAutoExpandColumn("helbidea");
	}

	public void setGuneak(Object[][] guneak) {
		Object[][] data = guneak;
		MemoryProxy proxy = new MemoryProxy(data);
		
		Store storeTemp = new Store(proxy, reader);
		storeTemp.reload();
		store.removeAll();
		store.add(storeTemp.getRecords());
	}

}
