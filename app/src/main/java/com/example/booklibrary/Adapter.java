package com.example.booklibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList bookId, bookTitle, bookAuthor, bookPages;


    Adapter(Activity activity, Context context, ArrayList bookId, ArrayList bookTitle, ArrayList bookAuthor,
            ArrayList bookPages){
            this.activity=activity;
            this.context=context;
            this.bookId=bookId;
            this.bookTitle=bookTitle;
            this.bookAuthor=bookAuthor;
            this.bookPages=bookPages;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.single_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.bookIdText.setText(String.valueOf(bookId.get(position)));
            holder.bookTitleText.setText(String.valueOf(bookTitle.get(position)));
            holder.bookAuthorText.setText(String.valueOf(bookAuthor.get(position)));
            holder.bookPagesText.setText(String.valueOf(bookPages.get(position)));
            holder.mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,UpdateActivity.class);
                    intent.putExtra("id",String.valueOf(bookId.get(position)));
                    intent.putExtra("title",String.valueOf(bookTitle.get(position)));
                    intent.putExtra("author",String.valueOf(bookAuthor.get(position)));
                    intent.putExtra("page",String.valueOf(bookPages.get(position)));
                    activity.startActivityForResult(intent,1);
                }
            });
    }

    @Override
    public int getItemCount() {
        return bookId.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView bookIdText, bookTitleText, bookAuthorText, bookPagesText;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            bookIdText= itemView.findViewById(R.id.bookId);
            bookTitleText= itemView.findViewById(R.id.bookTitle);
            bookAuthorText= itemView.findViewById(R.id.bookAuthor);
            bookPagesText= itemView.findViewById(R.id.bookPagesId);
            mainLayout=itemView.findViewById(R.id.mainlayout);
        }
    }
}
