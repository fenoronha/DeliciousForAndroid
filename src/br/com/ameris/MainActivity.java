package br.com.ameris;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import br.com.ameris.delicious.APIRequest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	private APIRequest apiRequest = null;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public String getDeliciousID()
    {
    	EditText txtdeliciousID = (EditText) findViewById(R.id.txtDeliciousID);
    	return txtdeliciousID.getText().toString();
    }
    
    public String getPassword()
    {
    	EditText  txtPassword = (EditText) findViewById(R.id.txtPassword);
    	return txtPassword.getText().toString();
    }
    
    public void signInHandler(View button) throws IOException
    {
    	apiRequest = new APIRequest();
    	apiRequest.login(getDeliciousID(), getPassword());
    }
}