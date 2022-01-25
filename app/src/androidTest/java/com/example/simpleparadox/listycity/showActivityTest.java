package com.example.simpleparadox.listycity;

import android.app.Activity;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.robotium.solo.Solo;
import org.junit.After; import org.junit.Before;
import org.junit.Rule; import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Text;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


@RunWith(AndroidJUnit4.class)

public class showActivityTest {
    private Solo solo;
    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class, true, true);
    /**
     * Runs before all tests and creates solo instance.
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),rule.getActivity());
    }

    @Test
    public void switchActivity(){
        ListView listView = (ListView) solo.getView(R.id.city_list);
        View view = listView.getChildAt(0);
        solo.clickOnView(view);
        solo.assertCurrentActivity("Activity Didn't Switched", ShowActivity.class);
    }

    @Test
    public void checkCityName(){
        ListView listView = (ListView) solo.getView(R.id.city_list);
        View view = listView.getChildAt(0);
        solo.clickOnView(view);
        TextView text = (TextView) solo.getView(R.id.textView1);
        String name = text.getText().toString();
        assertEquals("Edmonton", name);
    }

    @Test
    public void checkButton1(){
        ListView listView = (ListView) solo.getView(R.id.city_list);
        View view = listView.getChildAt(0);
        solo.clickOnView(view);
        solo.waitForActivity(ShowActivity.class);
        Button button = (Button) solo. getView(R.id.button1);
        solo.clickOnView(button);
        solo.assertCurrentActivity("Activity Didn't Switched", MainActivity.class);
    }

    /**
     * Close activity after each test
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception{
        solo.waitForActivity("showActivityTest", 2000);
        solo.finishOpenedActivities();

    }
}
