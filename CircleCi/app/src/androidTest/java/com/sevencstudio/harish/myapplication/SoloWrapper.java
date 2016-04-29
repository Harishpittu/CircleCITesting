package com.sevencstudio.harish.myapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.robotium.solo.Solo;

/**
 * Created by harish on 29/04/16.
 */
public class SoloWrapper extends Solo {


    Activity activity;

    public SoloWrapper(Instrumentation instrumentation, Activity activity) {

        super(instrumentation, activity);
        this.activity = activity;
    }

    public SoloWrapper(Instrumentation instrumentation, Config config) {
        super(instrumentation, config);
    }

    public SoloWrapper(Instrumentation instrumentation, Config config, Activity activity) {
        super(instrumentation, config, activity);
        this.activity = activity;
    }

    public SoloWrapper(Instrumentation instrumentation) {
        super(instrumentation);
    }


    public void setText(int EdittextId, String text) {
        EditText editText = (EditText) this.getCurrentActivity().findViewById(EdittextId);
        this.clearEditText(editText);
        this.enterText(editText, text);
    }

    public void clickButton(int ButtonId) {
        Button btn = (Button) this.getCurrentActivity().findViewById(ButtonId);
        this.clickOnView(btn);
    }

    public void clickImageView(int ButtonId) {
        ImageView btn = (ImageView) this.getCurrentActivity().findViewById(ButtonId);
        this.clickOnView(btn);
    }

    public void clickTextView(int ButtonId) {
        TextView btn = (TextView) this.getCurrentActivity().findViewById(ButtonId);
        this.clickOnView(btn);
    }
    public void clickRelativeLayout(int ButtonId) {
        RelativeLayout btn = (RelativeLayout) this.getCurrentActivity().findViewById(ButtonId);
        this.clickOnView(btn);
    }
    public void clickCheckBox(int ButtonId) {

        CheckBox btn = (CheckBox) this.getCurrentActivity().findViewById(ButtonId);
        this.clickOnView(btn);
    }

    public String getEditTextValue(int EdittextId) {
        EditText editText = (EditText) this.getCurrentActivity().findViewById(EdittextId);
        return editText.getText().toString();
    }
//    public void ClickRecyclerViewItem(int RecyclerViewID,int Position)
//    {
//        RecyclerView recyclerView = (RecyclerView) this.getCurrentActivity().findViewById(RecyclerViewID);
//        View view = recyclerView.findViewHolderForAdapterPosition(Position).itemView;
//        this.clickOnView(view);
//    }

    public View getViewAtIndex(final ListView listElement, final int indexInList, Instrumentation instrumentation) {
        ListView parent = listElement;
        if (parent != null) {
            if (indexInList <= parent.getAdapter().getCount()) {
                scrollListTo(parent, indexInList, instrumentation);
                int indexToUse = indexInList - parent.getFirstVisiblePosition();
                return parent.getChildAt(indexToUse);
            }
        }
        return null;
    }

    public <T extends AbsListView> void scrollListTo(final T listView,
                                                     final int index, Instrumentation instrumentation) {
        instrumentation.runOnMainSync(new Runnable() {
            @Override
            public void run() {
                listView.setSelection(index);

            }
        });
        instrumentation.waitForIdleSync();
    }

}
