package com.example.afreen.androiddevelopertest;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.InputStream;

public class UserProfileActivity extends AppCompatActivity {

    ImageView profileImage, dash;
    LinearLayout layout_item;
    TextView profileName, profileNumber, telephones, work, workPhone, home, homePhone, other, otherPhone;
    ProgressDialog pd;
    FetchData fetchData;
    private RecyclerView recyclerView;
    private TelephoneNumberAdapter telephoneNumberAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_activity);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        init();
        showProgressBar();

        new FetchData(new FetchData.ProfileResponseCallback() {
            @Override
            public void onSuccess(Profile profile) {
                displayProfile(profile);

            }
        }).execute();
    }

    private void showProgressBar() {

        pd = ProgressDialog.show(UserProfileActivity.this, "", "Please Wait", false);
    }

    private void displayProfile(Profile profile) {
        profileName.setText(profile.name);
        profileNumber.setText("#" + profile.userNumber);

        telephoneNumberAdapter = new TelephoneNumberAdapter(profile.telephoneNumbers);
        recyclerView.setAdapter(telephoneNumberAdapter);
        telephoneNumberAdapter.notifyDataSetChanged();
        new DownloadImageTask(profileImage).execute(profile.profileURL);
        pd.dismiss();
    }

    private void init() {

        profileImage = findViewById(R.id.profileImage);
        dash = findViewById(R.id.dash);
        profileName = findViewById(R.id.profileName);
        profileNumber = findViewById(R.id.profileNumber);
        telephones = findViewById(R.id.telephones);
        layout_item = findViewById(R.id.layout_item);
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
            bmImage.setClipToOutline(true);
        }
    }
}
