package com.example.afreen.androiddevelopertest;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FetchData extends AsyncTask<Void, Void, String> {

    final ProfileResponseCallback profileResponseCallback;
    String data = "";
    private TelephoneNumberAdapter telephoneNumberAdapter;

    public FetchData(ProfileResponseCallback profileResponseCallback) {
        this.profileResponseCallback = profileResponseCallback;
    }

    public static String formatName(String value) {
        String name = value;
        name = name.replace("\n", "");
        name = name.replaceAll("\\s\\s", " ");
        return name;
    }

    @Override
    protected String doInBackground(Void... voids) {

        HttpHandler http = new HttpHandler();
        String response = "";
        try {
            response = http.makeGetRequest(Constants.DATA_API);
            Log.d("Response from JSON", response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);

        if (response != null) {
            try {
                JSONObject jsonObject = new JSONObject(response);

                String name = jsonObject.getString("name");
                name = formatName(name);
                String uuid = jsonObject.getString("uuid");
                String profileURL = jsonObject.getString("profile_url");
                String userNumber = jsonObject.getString("user_number");

                JSONArray telephoneNumbersJson = jsonObject.getJSONArray("telephone_numbers");
                ArrayList<TelephoneNumber> telephoneNumbers = new ArrayList<>();
                for (int i = 0; i < telephoneNumbersJson.length(); i++) {
                    JSONObject telephoneNumbersJSONObject = telephoneNumbersJson.getJSONObject(i);
                    telephoneNumbers.add(new TelephoneNumber(telephoneNumbersJSONObject.getString("type"), telephoneNumbersJSONObject.getString("number")));
                }
                profileResponseCallback.onSuccess(new Profile(uuid, name, profileURL, userNumber, telephoneNumbers));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    interface ProfileResponseCallback {

        void onSuccess(Profile profile);
    }
}
