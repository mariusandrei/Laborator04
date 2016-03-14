package ro.pub.cs.systems.pdsd.lab04.contactsmanager;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class ContactsManagerActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_manager);
        Button save = (Button) findViewById(R.id.button2);
        
        save.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View v) {
                myFancyMethod(v);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contacts_manager, menu);
        return true;
    }

    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
        
    public void myFancyMethod(View v) {

        	EditText name  = (EditText)findViewById(R.id.name);
        	
        	
        	Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
            intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            if (name.getText() != null) {
              intent.putExtra(ContactsContract.Intents.Insert.NAME, name.getText());
            }
            
            EditText my_phone  = (EditText)findViewById(R.id.phone);
           
            if (my_phone.getText() != null) {
              intent.putExtra(ContactsContract.Intents.Insert.PHONE, my_phone.getText());
            }
            
        	EditText my_email  = (EditText)findViewById(R.id.email);
            if (my_email.getText() != null) {
              intent.putExtra(ContactsContract.Intents.Insert.EMAIL, my_email.getText());
            }
            
            
            EditText my_address  = (EditText)findViewById(R.id.address);
            
            if (my_address.getText() != null) {
              intent.putExtra(ContactsContract.Intents.Insert.POSTAL, my_address.getText());
            }
            /*
            if (jobTitle != null) {
              intent.putExtra(ContactsContract.Intents.Insert.JOB_TITLE, jobTitle);
            }
            if (company != null) {
              intent.putExtra(ContactsContract.Intents.Insert.COMPANY, company);
            }
           
            ArrayList<ContentValues> contactData = new ArrayList<ContentValues>();
            if (website != null) {
              ContentValues websiteRow = new ContentValues();
              websiteRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Website.CONTENT_ITEM_TYPE);
              websiteRow.put(ContactsContract.CommonDataKinds.Website.URL, website);
              contactData.add(websiteRow);
            }
            if (im != null) {
              ContentValues imRow = new ContentValues();
              imRow.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Im.CONTENT_ITEM_TYPE);
              imRow.put(ContactsContract.CommonDataKinds.Im.DATA, im);
              contactData.add(imRow);
            }
            
            intent.putParcelableArrayListExtra(ContactsContract.Intents.Insert.DATA, contactData);
            */
          	startActivity(intent);
    }    
    
    
    
    
}
