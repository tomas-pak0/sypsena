package lt.tyliaitpk.sypsena;

import android.content.Context;
import android.os.Build;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;
import android.media.AudioAttributes;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "Vibration")
public class VibrationPlugin extends Plugin {
    private Vibrator vibrator() {
        if (Build.VERSION.SDK_INT >= 31) {
            return ((VibratorManager) getContext().getSystemService(Context.VIBRATOR_MANAGER_SERVICE)).getDefaultVibrator();
        }
        return (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
    }
    @PluginMethod
    public void vibrate(PluginCall call) {
        Vibrator v = vibrator();
        if (v == null || !v.hasVibrator()) { call.reject("Vibrator unavailable"); return; }
        boolean doubleTone = Boolean.TRUE.equals(call.getBoolean("double", true));
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                VibrationEffect effect = doubleTone
                    ? VibrationEffect.createWaveform(new long[]{0,220,100,220}, -1)
                    : VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);
                if (Build.VERSION.SDK_INT >= 33) {
                    v.vibrate(effect, new VibrationAttributes.Builder().setUsage(VibrationAttributes.USAGE_ALARM).build());
                } else {
                    v.vibrate(effect, new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ALARM).build());
                }
            } else {
                v.vibrate(doubleTone ? new long[]{0,220,100,220} : new long[]{0,300}, -1);
            }
            call.resolve();
        } catch (RuntimeException e) { call.reject("Vibration failed", e); }
    }
    @PluginMethod
    public void cancel(PluginCall call) {
        Vibrator v = vibrator();
        if (v != null) v.cancel();
        call.resolve();
    }
}
