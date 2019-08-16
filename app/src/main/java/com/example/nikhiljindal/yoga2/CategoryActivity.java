package com.example.nikhiljindal.yoga2;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import static com.example.nikhiljindal.yoga2.R.id.*;

public class CategoryActivity extends AppCompatActivity {

    final Context context=this;

    SQLiteDatabase yogadb;
    ListView lst;
    AdaptorCategory mcategoryadaptor;
    ProgressDialog pDialog;
    ArrayList<class_category> catlst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


        lst = (ListView) findViewById(R.id.lst);

        String destPath= "/data/data/" + getPackageName() +
                "/databases";

        File f= new File(destPath);
        Log.d("Successful",destPath);

        if(!f.exists()){
            f.mkdirs();
            try {
                f.createNewFile();

                CopyDB(getBaseContext().getAssets().open("yogadb"), new FileOutputStream(destPath+"/yogadb"));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        catlst= new ArrayList<class_category>();

        yogadb=openOrCreateDatabase("yogadb",Context.MODE_PRIVATE,null);
        Cursor c = yogadb.rawQuery("SELECT * FROM Yogae",null);

        if(c.getCount()==0){
            dispMessage("Error","No Records Found");
            return;
        }

        while (c.moveToNext()){

            class_category cat = new class_category(c.getString(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4));
            catlst.add(cat);
        }

        ArrayList<String>clist= new ArrayList<String>();

        for (int i=0;i<catlst.size();i++){

            clist.add(catlst.get(i).getAsana_name());

        }

        //ArrayAdapter<String> catadaptor= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,clist);

        mcategoryadaptor = new AdaptorCategory(catlst,getLayoutInflater());

        lst.setAdapter(mcategoryadaptor);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int p = position;

                String asana_name = catlst.get(position).getAsana_name();
                String precautions = catlst.get(position).getPrecautions();
                String benefits = catlst.get(position).getBenefits();
                String description = catlst.get(position).getDescription();
                String image = catlst.get(position).getImage();


                Intent i = new Intent(getApplicationContext(), DetailCategory.class);
                i.putExtra("asana_name",asana_name);
                i.putExtra("precautions",precautions);
                i.putExtra("description",description);
                i.putExtra("benefits",benefits);
                i.putExtra("image",image);
                startActivity(i);
            }
        });

        yogadb=openOrCreateDatabase("yogadb", Context.MODE_PRIVATE, null);
        yogadb.execSQL("CREATE TABLE IF NOT EXISTS Yogae(asana_name VARCHAR,description VARCHAR,benefits VARCHAR,precautions VARCHAR,image VARCHAR);");


    }

    public void CopyDB(InputStream yogadb, OutputStream outputStream) throws IOException {
        byte [] buffer = new byte[1024];
        int length;

        while ((length=yogadb.read(buffer))>0){

            outputStream.write(buffer,0,length);

        }
        yogadb.close();
        outputStream.close();

    }

    public void dispMessage(String title,String message) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        // set title
        alertDialogBuilder.setTitle(title);

        // set dialog message
        alertDialogBuilder
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // if this button is clicked, close
                        // current activity
                        //MainActivity.this.finish();
                        dialog.cancel();
                    }
                });
					/*.setNegativeButton("No",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							// if this button is clicked, just close
							// the dialog box and do nothing
							dialog.cancel();
						}
					});*/

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();


    }

    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);

        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }









}

