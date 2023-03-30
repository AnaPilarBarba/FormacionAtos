package com.example.actividad10;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.actividad10.databinding.CustomViewEjBinding;

public class CustomViewEjemplo extends LinearLayout {

    private CustomViewEjBinding binding;

    public CustomViewEjemplo(Context context) {
        super(context);

        init(context, null);
    }

    public CustomViewEjemplo(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context, attrs);
    }

    public CustomViewEjemplo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs){
        binding = CustomViewEjBinding.inflate(LayoutInflater.from(context), this, true);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomViewEjemplo);

        try {
            binding.editCustom.setHint(typedArray.getString(R.styleable.CustomViewEjemplo_hint));

            binding.editCustom.setOnKeyListener((view, i, keyEvent) -> {

                if (binding.editCustom.getText().length() > 9){
                    binding.textCustom.setText("No sepuede tener más de 9 caracteres");
                    binding.textCustom.setVisibility(VISIBLE);

                }else {
                    binding.textCustom.setVisibility(GONE);
                }
                    return true;
            });
           /* String error = typedArray.getString(R.styleable.CustomViewEjemplo_text);

            if (error != null && !error.isEmpty()){
                binding.textCustom.setText(typedArray.getString(R.styleable.CustomViewEjemplo_text));
                binding.textCustom.setVisibility(VISIBLE);

            }else {
                binding.textCustom.setVisibility(GONE);
            }*/
        }
        finally {
            typedArray.recycle();
        }
    }

    public void setHint(String text){
        binding.textCustom.setText(text);
    }

    public void setError(String error){
        if (error != null && !error.isEmpty()){
            binding.textCustom.setText(error);
            binding.textCustom.setVisibility(VISIBLE);

        }else {
            binding.textCustom.setVisibility(GONE);
        }
    }

}
