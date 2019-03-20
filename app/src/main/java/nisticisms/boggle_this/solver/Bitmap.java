package nisticisms.boggle_this.solver;

public class Bitmap {
    public enum Direction {
        NORTH,
        EAST,
        SOUTH,
        WEST,
    }

    public static final int[] BOARD = {
        0x0,
        0x0,
        0x0,
        0x0,
        0xFFFF,
        0x01FFFFFF,
    };

    public static final int[][] EDGE = {
        {}, {}, {}, {},
        {
            0xF000,
            0x1111,
            0x000F,
            0x8888,
        },
        {
            0x01F00000,
            0x00108421,
            0x0000001F,
            0x01084210,
        },
    };


    public int map;
    public int stride;

    public Bitmap(int map, int stride) {
        this.map = map;
        this.stride = stride;
    }

    public void set(int x, int y) {
        this.map |= 0x01 << this.stride * y + (this.stride - 1 - x);
    }

    public void clear(int x, int y) {
        this.map &= ~(0x01 << this.stride * y + (this.stride - 1 - x));
    }

    public boolean get(int x, int y) {
        return (this.map & (0x01 << this.stride * y + (this.stride - 1 - x))) != 0;
    }

    public void shift(Direction direction, int offset) {
        for (int i = 0; i < offset; i++) {
            switch (direction) {
                case NORTH:
                    this.map <<= this.stride;
                    this.map &= BOARD[this.stride];
                    break;
                case EAST:
                    this.map >>= 1;
                    this.map &= BOARD[this.stride] & ~EDGE[this.stride][Direction.WEST.ordinal()];
                    break;
                case SOUTH:
                    this.map >>= this.stride;
                    this.map &= BOARD[this.stride];
                    break;
                case WEST:
                    this.map <<= 1;
                    this.map &= BOARD[this.stride] & ~EDGE[this.stride][Direction.EAST.ordinal()];
                    break;
            }
        }
    }

    public Bitmap getEmptyBitsAround(int x, int y) {
        int oldMap = this.map;

        // Avoid creating another object by reusing this one
        this.map = 0;
        this.set(x, y); int map = this.map;
        this.shift(Direction.NORTH, 1); this.map |= map; map = this.map;
        this.shift(Direction.EAST, 1); this.map |= map; map = this.map;
        this.shift(Direction.SOUTH, 1); this.map |= map; map = this.map;
        this.shift(Direction.WEST, 1); this.map |= map;
        this.clear(x, y);

        int emptyBits = this.map & ~oldMap;

        this.map = oldMap;
        return new Bitmap(emptyBits, this.stride);
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int y = this.stride - 1; y >= 0; y--) {
            for (int x = 0; x < this.stride; x++) {
                if (this.get(x, y)) {
                    string.append(1);
                } else {
                    string.append(0);
                }
            }
            string.append('\n');
        }
        return string.toString();
    }
}
