package com.example.feder.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.plaid.client.PlaidClient;
import com.plaid.client.request.InstitutionsGetRequest;
import com.plaid.client.response.Institution;
import com.plaid.client.response.InstitutionsGetResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Feder on 7/30/2017.
 */

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String instutionId = getIntent().getStringExtra("INSTITUTION_ID");
        setContentView(R.layout.login);
        final PlaidClient client = PlaidClient.newBuilder()
                .clientIdAndSecret("597a300abdc6a45a44411125", "e877da17f30530c7453fac330b21bb")
                .publicKey("6dba185e37f648387f77010df4592b")
                .sandboxBaseUrl()
                .build();
        EditText username = (EditText) findViewById(R.id.username_input);
        EditText password = (EditText) findViewById(R.id.password_input);
        Button submit = (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }

}
