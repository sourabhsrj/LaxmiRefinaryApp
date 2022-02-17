package com.example.LaxmiRefinary;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Vector;

public class Ads extends AppCompatActivity {

    RecyclerView recyclerView;
    Vector<YoutubeVideos > youtubeVideosVector=new Vector<>();

    @SuppressLint("NonConstantResourceId")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);

        getWindow().getDecorView().setSystemUiVisibility(
                4098);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=xWkhxvn5GSw&list=PLh2bIG3zccvCoBMW6GkBFnIOsSIz7h5cP&index=1\" framebolder=\"0\" allowfullscreen></iframe>"));
        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/watch?v=xWkhxvn5GSw&list=PLh2bIG3zccvCoBMW6GkBFnIOsSIz7h5cP&index=1\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/xWkhxvn5GSw&list=PLh2bIG3zccvCoBMW6GkBFnIOsSIz7h5cP&index=1\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PLh2bIG3zccvCoBMW6GkBFnIOsSIz7h5cP&index=1\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/nFBdDaK_6Ko\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/vHgXavq2s3U\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/55NtOmuZMbc\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PDD6kDM7svY\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/U1shtj805AE\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/FPANmqfXnTw\" framebolder=\"0\" allowfullscreen></iframe>"));
//
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/XtyLfJa3clI\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Qt3ZIwPn_ZA\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/cAo2Ky1ONrU\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/5r8PkdnyfDs\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/SgvCMxYPOFs\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/XvzQkSwwPhg\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/N7G-kGvai4M\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_BUQUYu-5e0\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lq6TgH71BSg\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tyn8uGWGGWc\" framebolder=\"0\" allowfullscreen></iframe>"));
//
//
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/ggBIyXXSI5M\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/agdif9Q1w4M\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/_zrPmDEMsMc\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/5YQhvKilb80\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Xom0GkLdmJ0\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/W_9gsCbOA2E\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/lgbEwgtjI2s\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Zo9_i-rCnNQ\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/HnoPHqrdXQ8\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/T1XLHsz4r_M\" framebolder=\"0\" allowfullscreen></iframe>"));
//
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/fC5vyMERa94\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/5bIgsBCuuB8\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/zkDUui4BI8M\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/sbZRAKf2S1o\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/FO3aglziCxE\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/I3Pqf5FQiZc\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/01OI5lGoMhw\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/x6jmxj7B1VA\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/u0gkkrLptwA\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/eT3xIgzbhGM\" framebolder=\"0\" allowfullscreen></iframe>"));
//
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/VdQv2dbOJqc\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/T1XLHsz4r_M\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/Qn0Xn-lZ0E8\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/WG7BbyvxBMk\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/vK5SoQXvehM\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/PjdpsEW2k7g\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/UVa117ianQQ\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/JpXu8_9G3cY\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/EY2YkXtTxg4\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/te8mslQ-TvY\" framebolder=\"0\" allowfullscreen></iframe>"));
//
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tPEQTJm1hs4\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/CIJ9Cq21uwo\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/oA247PQ0too\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/xayWitaHIw4\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/UlqjHQxWtP8\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/O6Xn--gV0_w\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/V2cVjTyHlzY\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/rw9HNlPke-w\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youthttps://www.youtube.com/embedube.com/embed/Pa8G2xWel6c\" framebolder=\"0\" allowfullscreen></iframe>"));
//        youtubeVideosVector.add(new YoutubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/sQFRWxKgRKA\" framebolder=\"0\" allowfullscreen></iframe>"));

//        https://www.youtube.com/watch?v=xWkhxvn5GSw&list=PLh2bIG3zccvCoBMW6GkBFnIOsSIz7h5cP&index=1


        VideoAdapter videoAdapter=new VideoAdapter(youtubeVideosVector);
        recyclerView.setAdapter(videoAdapter);










        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent home = new Intent(Ads.this,HomeActivity.class);
                    startActivity(home);
                    overridePendingTransition(0, 0);
                    break;
                case R.id.navigation_ads:
                    break;
                case R.id.navigation_connect:
                    Intent connect = new Intent(Ads.this,ConnectActivity.class);
                    startActivity(connect);
                    overridePendingTransition(0, 0);
                    break;

            }
            return false;
        });

    }


}
