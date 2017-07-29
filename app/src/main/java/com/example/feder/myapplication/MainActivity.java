package com.example.feder.myapplication;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.plaid.client.PlaidClient;
import com.plaid.client.request.AccountsGetRequest;
import com.plaid.client.request.InstitutionsGetRequest;
import com.plaid.client.request.ItemCreateRequest;
import com.plaid.client.request.ItemPublicTokenExchangeRequest;
import com.plaid.client.request.TransactionsGetRequest;
import com.plaid.client.request.common.Product;
import com.plaid.client.response.AccountsGetResponse;
import com.plaid.client.response.ErrorResponse;
import com.plaid.client.response.Institution;
import com.plaid.client.response.InstitutionsGetResponse;
import com.plaid.client.response.ItemCreateResponse;
import com.plaid.client.response.ItemPublicTokenExchangeResponse;
import com.plaid.client.response.TransactionsGetResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final PlaidClient client = PlaidClient.newBuilder()
                .clientIdAndSecret("597a300abdc6a45a44411125", "e877da17f30530c7453fac330b21bb")
                .publicKey("6dba185e37f648387f77010df4592b")
                .sandboxBaseUrl()
                .build();

        client.service()
                .institutionsGet(new InstitutionsGetRequest(3, 0))
                .enqueue(new Callback<InstitutionsGetResponse>() {
                    @Override
                    public void onResponse(Call<InstitutionsGetResponse> call, Response<InstitutionsGetResponse> response) {
                        if (response.isSuccessful()) {
                            List<Institution> institutions = response.body().getInstitutions();
                        }
                    }
                    @Override
                    public void onFailure(Call<InstitutionsGetResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
