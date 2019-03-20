package nisticisms.boggle_this.solver;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public class Letter {
        public final Bitmap location;
        public final int x, y;
        public final String value;

        public Letter(String value, int x, int y, int stride) {
            this.value = value;
            this.x = x;
            this.y = y;
            this.location = new Bitmap(0, stride);
            this.location.set(x, y);
        }

        public String toString() {
            return String.format("(%d, %d, %d, %s)", this.x, this.y, this.location.map, this.value);
        }
    }

    public Letter[] letters;
    public int stride;

    public Board(String[] letters, int stride) {
        this.letters = new Letter[stride * stride];
        for (int i = 0; i < stride * stride; i++) {
            int x = i % stride;
            int y = stride - 1 - i / stride;
            this.letters[i] = new Letter(letters[i], x, y, stride);
        }

        this.stride = stride;
    }

    public Letter get(int x, int y) {
        return this.letters[(this.stride - 1 - y) * this.stride + x];
    }

    public List<Letter> getLettersFromBitmap(Bitmap bitmap) {
        ArrayList<Letter> letters = new ArrayList<Letter>();

        for (Letter letter : this.letters) {
            if ((letter.location.map & bitmap.map) != 0) {
                letters.add(letter);
            }
        }

        return letters;
    }
}
