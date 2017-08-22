package knobview.rhodonite.com.knobview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    KnobView kv;
    int t1_temp = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kv = (KnobView) this.findViewById(R.id.t1);
        kv.setMax(16);
        kv.setProgress(8);
        kv.setProgressChangeListener(new KnobView.OnProgressChangeListener() {
            @Override
            public void onProgressChanged(boolean fromUser, int progress) {
                if (t1_temp != progress) {
                    t1_temp = progress;
                    if (progress == 0)
                        kv.setProgress(0);
                }
            }
            @Override
            public void onStartTrackingTouch(KnobView view, int progress) {
            }
            @Override
            public void onStopTrackingTouch(KnobView view, int progress) {
                if (progress == 0)
                    kv.setProgress(0);
            }
        });
    }
}
