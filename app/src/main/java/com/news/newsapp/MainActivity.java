package com.news.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   //sample list of items to be traversed by the search view
  /*   ListView listView;
    String[] name={"Avery","Morgan","Jordan","Taylor","Alexis","Casey","Jamie","Dakota","Riley","Hayden","Reese","Angel","Parker","Quinn","Sage","Charlie","Emerson","Finley","Harley","Justice","Kendall","Phoenix","River","Rowan","Skyler","Tanner","Addison","Avery","Bailey","Cameron","Carter","Dakota","Drew","Hayden","Hunter","Jordan","Logan"};
    ArrayAdapter<String> arrayAdapter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* listView = findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,name);
        listView.setAdapter(arrayAdapter);*/
       // startActivity(new Intent(MainActivity.this, RegisterActivity.class));
    }

    //The search Activity code STARTS here

/*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Here");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                arrayAdapter.getFilter().filter(newText);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    //The search Activity code ENDS here */


}

