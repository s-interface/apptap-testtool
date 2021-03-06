package fu.berlin.apptap_helptool;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import fu.berlin.apptap_helptool.extra.SmaliCodeClazz;

public class MainActivity extends AppCompatActivity {

    private Button mTestButton;
    private Button mSendEventButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        mTestButton = findViewById(R.id.test_button);
        mSendEventButton = findViewById(R.id.send_event_button);

//        mTestButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, R.string.test_button, Toast.LENGTH_SHORT).show();
//            }
//        });
        mSendEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, R.string.send_event_button, Toast.LENGTH_SHORT).show();
                sendEvent();
            }
        });
    }

    /**
     * called by button click in testtool GUI
     * <p>
     * send a test event through SmaliCodeClass to emulate calling of the hook method and sending an
     * event with the help of AppTapHelper
     */
    private void sendEvent() {
        long currentTime = System.currentTimeMillis();
        SmaliCodeClazz smaliClass = new SmaliCodeClazz();
        Bundle bundle = new Bundle();
        bundle.putString("description", "This is a test event");
        bundle.putString("parameter_key", "parameter_value");
        smaliClass.targetMethod("_test_origin", "test_event", currentTime, bundle, true, true, true, "third_string");
    }
}
