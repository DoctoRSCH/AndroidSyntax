package com.ibquezada.android.FastCode;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.EditText;

public class SyntaxHighlightEditText extends EditText {
    private TextWatcher myWatcher = null;
    private ForegroundColorSpan fcs = new ForegroundColorSpan(Color.rgb(255, 0, 0));

    final SyntaxHighlightEditText that = this;

    private void createWatcherForEditor() {
        myWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String actualCode = that.getText().toString();
                int codeLength = actualCode.length();
                if (codeLength > 4) {
                    codeLength = 4;
                }

                s.setSpan(fcs, 0, codeLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);

            }
        };
    }

    public SyntaxHighlightEditText(Context context) {
        super(context);
        init();
    }

    public SyntaxHighlightEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SyntaxHighlightEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        this.createWatcherForEditor();
        this.addTextChangedListener(this.myWatcher);
    }
}
