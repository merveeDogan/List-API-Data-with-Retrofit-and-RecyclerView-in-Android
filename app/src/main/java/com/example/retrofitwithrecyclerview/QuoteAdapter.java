package com.example.retrofitwithrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder> {
    List<QuotesModel> quotes;
    Context context;

    public QuoteAdapter(List<QuotesModel> quotes, Context context) {
        this.quotes = quotes;
        this.context = context;
    }

    @Override
    public QuoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_quote,parent,false);
        QuoteViewHolder quoteViewHolder = new QuoteViewHolder(view);
        return quoteViewHolder;
    }

    @Override
    public void onBindViewHolder(QuoteAdapter.QuoteViewHolder holder, int position) {
        QuotesModel quote= quotes.get(position);
        holder.textViewQuote.setText(quote.getQuote());
        holder.textViewAuthor.setText(quote.getAuthor());

        int backgroundColor = position % 2 == 0 ?
                0xFFFFFBF5 :
                0xFFF7EFE5;
        holder.itemView.setBackgroundColor(backgroundColor);
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    class QuoteViewHolder extends RecyclerView.ViewHolder {
        TextView textViewQuote;
        TextView textViewAuthor;
        public QuoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewQuote = itemView.findViewById(R.id.textViewQuote);
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor);
        }
    }
}
