
package synthesizer;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {


    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] strings = new GuitarString[keyboard.length()];
        double sample = 0.0;
        // store keyboard sequences in array
        for (int i = 0; i < keyboard.length(); i++) {
            strings[i] = new GuitarString(440 * Math.pow(2, i / 12 - 2) );
        }
        while (true) {
            sample = 0;
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index != -1) {
                    strings[index].pluck();
                }
            }

            /* compute the superposition of samples */
            for (int i = 0; i < keyboard.length(); i++) {
                sample += strings[i].sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);
            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < keyboard.length(); i++) {
                strings[i].tic();
            }
        }
    }
}
