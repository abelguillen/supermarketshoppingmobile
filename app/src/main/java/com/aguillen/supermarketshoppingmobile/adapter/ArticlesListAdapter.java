package com.aguillen.supermarketshoppingmobile.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.aguillen.supermarketshoppingmobile.R;
import com.aguillen.supermarketshoppingmobile.model.Article;
import com.aguillen.supermarketshoppingmobile.service.ArticleService;
import com.aguillen.supermarketshoppingmobile.util.Environment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArticlesListAdapter extends BaseAdapter {

    private Context context;
    private List<Article> articles;
    private LayoutInflater inflter;

    public ArticlesListAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
        inflter = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public Object getItem(int i) {
        return articles.get(i);
    }

    @Override
    public long getItemId(int i) {
        return articles.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        view = inflter.inflate(R.layout.activity_row_article, null);

        TextView name = (TextView) view.findViewById(R.id.tv_name);
        TextView description = (TextView) view.findViewById(R.id.tv_description);
        TextView category = (TextView) view.findViewById(R.id.tv_category);
        ImageView image = (ImageView) view.findViewById(R.id.iv_image) ;
        Button btDeleteArticle = (Button) view.findViewById(R.id.bt_delete_article);

        btDeleteArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getRootView().getContext(), R.style.Theme_AppCompat_DayNight_Dialog_Alert);
                builder.setTitle("Eliminar Articulo");
                builder.setMessage("¿Esta seguro que desea eliminar el articulo?");
                builder.setCancelable(false);
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteArticle(articles.get(i));
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.background_light);
                return;
            }
        });

        name.setText(articles.get(i).getName());
        description.setText(articles.get(i).getDescription());
        category.setText(articles.get(i).getCategory());

        byte[] decodedString = Base64.decode(articles.get(i).getImage(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        image.setImageBitmap(decodedByte);

        return view;
    }

    public void deleteArticle(Article article) {
        String BASE_URL = "";
        try {
            BASE_URL = Environment.getHost();
        } catch (Exception ex) {
            Log.e("Connection Error", ex.getMessage());
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ArticleService service = retrofit.create(ArticleService.class);
        Call<Boolean> call = service.delete(article.getId());

        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                articles.remove(article);
                notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                Log.e("Delete Article error: ", t.getMessage());
            }
        });
    }
}
