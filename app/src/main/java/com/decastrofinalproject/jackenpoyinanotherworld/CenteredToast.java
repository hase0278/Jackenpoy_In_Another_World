package com.decastrofinalproject.jackenpoyinanotherworld;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;

public class CenteredToast {
    public static Spannable centerText(String text){
        Spannable centeredText = new SpannableString(text);
        centeredText.setSpan(
                new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),
                0, text.length() - 1,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE
        );
        return centeredText;
    }
}
