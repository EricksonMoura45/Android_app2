package com.example.socialmediaapp.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.socialmediaapp.Adapters.PostAdapter;
import com.example.socialmediaapp.Adapters.StoryAdapter;
import com.example.socialmediaapp.Data.PostService;
import com.example.socialmediaapp.Models.PostItem;
import com.example.socialmediaapp.Models.StoryItem;
import com.example.socialmediaapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView tv_uname, tv_greeting, tv_location;
    EditText et_searchBar;
    CircleImageView cv_homePic;
    ImageView iv_locationButton;

    RecyclerView storyRecyclerView;
    RecyclerView postRecyclerView;

    StoryAdapter storyAdapter;
    PostAdapter postAdapter;



    // story recycler view
    int[] img_story;
    boolean[] isStory;

    // post recycler view
    int[] img_post;
    int[] img_display;
    String[] txt_name;
    String[] txt_time;

    private List<PostItem> postListItems = new ArrayList<>();
    private List<StoryItem> storyListItems = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_uname = (TextView) findViewById(R.id.textView_username);
        tv_greeting = (TextView) findViewById(R.id.textView_greeting);
        et_searchBar = (EditText) findViewById(R.id.editText_searchBar);
        cv_homePic = (CircleImageView) findViewById(R.id.home_profile_image);
        tv_location = (TextView) findViewById(R.id.textView_adress);
        iv_locationButton = (ImageView) findViewById(R.id.imageView_location);


        Typeface myFont = Typeface.createFromAsset(getAssets(),"font/as_bold.ttf");
        Typeface myFont1 = Typeface.createFromAsset(getAssets(),"font/Roboto-Bold.ttf");

        et_searchBar.setTypeface(myFont);
        tv_uname.setTypeface(myFont);
        tv_greeting.setTypeface(myFont1);


        cv_homePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(MainActivity.this, Profile.class);
                startActivity(profileIntent);
            }
        });


        intializeStory();
        initializePosts();

        getStory();
        getPosts();

    }

    private  void initializeRetrofitUsers(){


    }


    private void initializePosts(){

        postRecyclerView = findViewById(R.id.rv_post);
        postRecyclerView.setHasFixedSize(true);
        postRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void intializeStory(){
        storyRecyclerView = findViewById(R.id.rv_story);
        storyRecyclerView.setHasFixedSize(true);
        storyRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

    }


    private void getStory(){


        img_story =  new int[] {R.drawable.ic_plus, R.drawable.matt, R.drawable.mathew, R.drawable.jennifer, R.drawable.harry, R.drawable.taylor, R.drawable.matt, R.drawable.mathew};
        isStory = new boolean[]{false,true,false,true,false,true,false,true};

        for(int i=0;i<img_story.length;i++){
            StoryItem storyItem = new StoryItem(img_story[i],
                    isStory[i]);

            storyListItems.add(storyItem);
        }

        storyAdapter = new StoryAdapter(storyListItems,this);
        storyRecyclerView.setAdapter(storyAdapter);

    }

    private void getPosts(){

        img_post = new int[]{R.drawable.em_7, R.drawable.em_11, R.drawable.em_12, R.drawable.em_1,R.drawable.em_8,R.drawable.em_9};
        img_display = new int[]{R.drawable.em_11, R.drawable.em_5,R.drawable.em_6, R.drawable.em_1,R.drawable.em_7,R.drawable.em_8};
        txt_name = new String[]{"Matt LeBlanc","Mathew Perry", "Jennifer Aniston","Harry Styles","Taylor Swift","Matt LeBlanc"};
        txt_time= new String[]{"13m ago", "20m ago", "45m ago",  "1h ago", "2h ago", "2h ago"};
        //Preencher com dados do  postList
        for(int i=0;i<txt_name.length;i++){
            PostItem postItem= new PostItem(
                    img_post[i],
                    img_display[i],
                    txt_name[i],
                    txt_time[i]);

            postListItems.add(postItem);

        }

        postAdapter = new PostAdapter(postListItems,this);
        postRecyclerView.setAdapter(postAdapter);

    }




}
