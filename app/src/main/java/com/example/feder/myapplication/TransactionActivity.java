package com.example.feder.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.plaid.client.PlaidClient;
import com.plaid.client.request.InstitutionsGetRequest;
import com.plaid.client.request.TransactionsGetRequest;
import com.plaid.client.response.InstitutionsGetResponse;
import com.plaid.client.response.TransactionsGetResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Feder on 7/31/2017.
 */

public class TransactionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = new Date();
        Date endDate = new Date();
        try {
            startDate = simpleDateFormat.parse("2017-01-01");
            endDate = simpleDateFormat.parse("2017-02-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String accessToken = getIntent().getStringExtra("ACCESS_TOKEN");
        setContentView(R.layout.transactions);
        ListView transactionList = (ListView) findViewById(R.id.transactions_list);

        final PlaidClient client = PlaidClient.newBuilder()
                .clientIdAndSecret("597a300abdc6a45a44411125", "e877da17f30530c7453fac330b21bb")
                .publicKey("6dba185e37f648387f77010df4592b")
                .sandboxBaseUrl()
                .build();

        client.service()
                .transactionsGet(new TransactionsGetRequest(accessToken, startDate, endDate))
                .enqueue(new Callback<TransactionsGetResponse>() {
                    @Override
                    public void onResponse(Call<TransactionsGetResponse> call, Response<TransactionsGetResponse> response) {
                        if(response.isSuccessful()){
                            response.body().getTransactions();
                        }
                    }

                    @Override
                    public void onFailure(Call<TransactionsGetResponse> call, Throwable t) {

                    }
                });
    }
}