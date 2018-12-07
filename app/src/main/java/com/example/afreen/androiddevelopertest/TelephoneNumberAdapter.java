package com.example.afreen.androiddevelopertest;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class TelephoneNumberAdapter extends RecyclerView.Adapter<TelephoneNumberAdapter.MyViewHolder> {

    private List<TelephoneNumber> telephoneNumberList;

    public TelephoneNumberAdapter(List<TelephoneNumber> telephoneNumberList) {
        this.telephoneNumberList = telephoneNumberList;
    }

    public static String formatPhoneNumber(String value) {
        String numString = value;
        numString = numString.replace("\n", "");
        numString = numString.replaceAll("\\s", "");
        numString = numString.substring(0, 3) + " " + "(" + numString.substring(3, 6) + ")" + " " + numString.substring(6, 9) + "-" + numString.substring(9, 13);
        return numString;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.telephone_number_item, parent, false);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull TelephoneNumberAdapter.MyViewHolder myViewHolder, int i) {
        final TelephoneNumber telephoneNumber = telephoneNumberList.get(i);
        myViewHolder.type.setText(telephoneNumber.getType());
        myViewHolder.number.setText(formatPhoneNumber(telephoneNumber.getNumber()));
    }

    @Override
    public int getItemCount() {
        return telephoneNumberList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView type, number;

        public MyViewHolder(View view) {
            super(view);
            type = view.findViewById(R.id.type);
            number = view.findViewById(R.id.number);
        }
    }


}
