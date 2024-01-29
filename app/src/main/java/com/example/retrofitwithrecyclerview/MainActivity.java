package com.example.retrofitwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<QuotesModel> quotesList=new ArrayList<>();
    private QuoteAdapter quoteAdapter;
    private RecyclerView recyclerView;
    QuoteAdapter quotesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        quoteAdapter=new QuoteAdapter(quotesList,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(quoteAdapter);

        getQuotes();
    }

    private void getQuotes(){
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<QuotesModel>> quotesCall= apiService.getQuotes();

        quotesCall.enqueue(new Callback<List<QuotesModel>>() {
            @Override
            public void onResponse(Call<List<QuotesModel>> call, Response<List<QuotesModel>> response) {
                if(response.isSuccessful()){
                    quotesList= response.body();
                    if(quotesList!= null && quotesList.size()>0){
                      quotesAdapter=new QuoteAdapter(quotesList,MainActivity.this);
                      recyclerView.setAdapter(quotesAdapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<QuotesModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Hata!",Toast.LENGTH_SHORT).show();
            }
        });
    }

}
