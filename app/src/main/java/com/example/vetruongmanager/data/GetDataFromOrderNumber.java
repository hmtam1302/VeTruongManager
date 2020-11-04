package com.example.vetruongmanager.data;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.vetruongmanager.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetDataFromOrderNumber extends AsyncTask<String, Void, String> {
    private Activity activity;
    private ProgressDialog loading;

    public GetDataFromOrderNumber(Activity activity){
        this.activity = activity;
        loading = new ProgressDialog(activity);
    }


    protected void onPreExecute() {
        this.loading.setMessage("Getting Data");
        this.loading.show();
    }

    @Override
    protected String doInBackground(String... params){

        String stringUrl = params[0];
        StringBuilder content = new StringBuilder();
        try
        {
            // create a url object
            URL url = new URL(stringUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
    protected void onPostExecute(String result){
        super.onPostExecute(result);

        if (loading.isShowing()) {
            loading.dismiss();
        }
        //Read JSON data
        try {
            JSONArray data = new JSONObject(result).getJSONArray("values");
            JSONObject object = data.getJSONObject(0);

            String name = object.getString("name"); //Index of name in data = 1
            String lop = object.getString("lop");
            String phoneNumber = object.getString("phone");

            //Set text for 3 EditTexts: Name, Class, PhoneNumber
            EditText editTextName = activity.findViewById(R.id.edit_text_name);
            editTextName.setText(name);
            EditText editTextClass = activity.findViewById(R.id.edit_text_class);
            editTextClass.setText(lop);
            EditText editTextPhoneNumber = activity.findViewById(R.id.edit_text_phone_number);
            editTextPhoneNumber.setText(phoneNumber);

        } catch (JSONException e) {
            Log.d("Error", e.toString());
        }


    }
}
