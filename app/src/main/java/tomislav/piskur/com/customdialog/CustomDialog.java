package tomislav.piskur.com.customdialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by srs on 20.09.2017.
 */

public class CustomDialog extends DialogFragment {

    private EditText etUnos;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Unesi text");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View customDialog = inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(customDialog);
        etUnos = (EditText) customDialog.findViewById(R.id.etInput);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String input = etUnos.getText().toString();
                MainActivity.setInputText(input);
            }
        });

    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dismiss();
        }
    });

return builder.create();

}
}