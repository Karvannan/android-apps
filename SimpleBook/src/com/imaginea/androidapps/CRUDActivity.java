package com.imaginea.androidapps;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CRUDActivity extends Activity {

	public static final int create = 1;
	public static final int update = 2;
	public static final int delete = 3;
	public static final int retrieve = 4;
	public static final int retrieveAll = 5;

	public List<Customer> data = createSampleData(10);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i("CRUDActivity", "CRUDActivity on Create loaded !!");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.crud_activity);
		Button btn_create = (Button) findViewById(R.id.btn_create);
		Button btn_update = (Button) findViewById(R.id.btn_update);
		Button btn_delete = (Button) findViewById(R.id.btn_delete);
		Button btn_retrieve = (Button) findViewById(R.id.btn_retrieve);
		Button btn_retrieveAll = (Button) findViewById(R.id.btn_retrieveAll);

		btn_create.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(create);
			}
		});

		btn_update.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(update);
			}
		});

		btn_delete.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(delete);
			}
		});

		btn_retrieve.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(retrieve);
			}
		});

		btn_retrieveAll.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(retrieveAll);
			}
		});

	}

	private static List<Customer> createSampleData(int range) {
		List<Customer> customers = new ArrayList<Customer>();
		for (int i = 1; i <= range; i++) {
			Customer customer = new Customer();
			customer.setCustomerFistName("first" + i);
			customer.setCustomerGender("male");
			customer.setCustomerId(i);
			customer.setCustomerLastName("last" + i);
			customers.add(customer);
		}
		return customers;
	}

	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {

		CustomerScreenAdapter adapter = null;
		Builder dialog = new AlertDialog.Builder(this);
		TextView current_action_text = (TextView) findViewById(R.id.current_action_text);
		ListView list_customer_list = (ListView) findViewById(R.id.list_customer_list);

		switch (id) {
		case create:
			data.clear();
			adapter = new CustomerScreenAdapter(this, data);
			list_customer_list.setAdapter(adapter);

			current_action_text.setText("Create Action");
			dialog.setIcon(R.drawable.ic_launcher);
			dialog.setTitle("Create Operation");
			dialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			dialog.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			break;
		case update:
			data.clear();
			adapter = new CustomerScreenAdapter(this, data);
			list_customer_list.setAdapter(adapter);

			current_action_text.setText("Update Action");
			dialog.setIcon(R.drawable.ic_launcher);
			dialog.setTitle("Update Operation");
			dialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			dialog.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			break;
		case delete:
			data.clear();
			adapter = new CustomerScreenAdapter(this, data);
			list_customer_list.setAdapter(adapter);

			current_action_text.setText("Delete Action");
			dialog.setIcon(R.drawable.ic_launcher);
			dialog.setTitle("Delete Operation");
			dialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			dialog.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			break;
		case retrieve:
			data.clear();
			adapter = new CustomerScreenAdapter(this, data);
			list_customer_list.setAdapter(adapter);

			current_action_text.setText("Retrieve Action");
			dialog.setIcon(R.drawable.ic_launcher);
			dialog.setTitle("Retrieve Operation");
			dialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			dialog.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			break;
		case retrieveAll:
			current_action_text.setText("Retrieve All Action");

			if (data == null || data.size() == 0) {
				data = createSampleData(10);
			}

			adapter = new CustomerScreenAdapter(this, data);
			list_customer_list.setAdapter(adapter);

			dialog.setIcon(R.drawable.ic_launcher);
			dialog.setTitle("Retrieve All Operation");
			dialog.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			dialog.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {

						}
					});
			break;

		}

		return dialog.create();
	}
}
