package com.imaginea.androidapps;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomerScreenAdapter extends BaseAdapter {

	Activity context;
	List<Customer> items;

	public CustomerScreenAdapter(Activity context, List<Customer> items) {		
		this.context = context;
		this.items = items;
	}	

	@Override
	public int getCount() {
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		return items.get(position).getCustomerId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Customer customer = items.get(position);
		View view = convertView;

		if (view == null)
			view = context.getLayoutInflater().inflate(R.layout.list_template,
					null);

		TextView textView_cust_first_name = (TextView) view
				.findViewById(R.id.textView_cust_first_name);
		TextView textView_cust_gender = (TextView) view
				.findViewById(R.id.textView_cust_gender);
		TextView textView_cust_id = (TextView) view
				.findViewById(R.id.textView_cust_id);
		TextView textView_cust_last_name = (TextView) view
				.findViewById(R.id.textView_cust_last_name);

		textView_cust_first_name.setText(customer.getCustomerFistName());
		textView_cust_gender.setText(customer.getCustomerGender());
		/*textView_cust_id.setText(customer.getCustomerId());*/
		textView_cust_last_name.setText(customer.getCustomerLastName());
		
		return view;
	}
}
