package nisticisms.boggle_this.solver;

import java.util.ArrayList;
import java.util.List;

public class TreeSolver implements Solver {
    private Board board;

    private class TreeNode {
        public TreeSolver solver;
        public Bitmap path;
        public Board.Letter letter;
        public List<TreeNode> children;

        public TreeNode(TreeSolver solver, Bitmap path, Board.Letter letter) {
            this.solver = solver;
            this.path = path;
            this.letter = letter;
        }

        public TreeNode(TreeSolver solver, List<TreeNode> children) {
            this.solver = solver;
            this.path = new Bitmap(0, solver.board.stride);
            this.children = children;
        }

        public String toString() {
            return String.format("(%s, %s)", (this.letter == null ? "no letter" : this.letter.toString()), (this.children == null ? "no children" : this.children.toString()));
        }

        private boolean expand() {
            if (this.children != null) {
                return false;
            }

            this.children = new ArrayList<TreeNode>(8);
            for (Board.Letter letter : this.solver.board.getLettersFromBitmap(this.path.getEmptyBitsAround(this.letter.x, this.letter.y))) {
                this.children.add(new TreeNode(this.solver, new Bitmap(this.path.map | letter.location.map, this.solver.board.stride), letter));
            }

            return true;
        }

        public boolean search(List<String> letters, int position) {
            this.expand();

            for (TreeNode child : this.children) {
                if (child.letter.value.equals(letters.get(position))) {
                    if (position < letters.size() - 1) {
                        if (child.search(letters, position + 1)) {
                            return true;
                        };
                    } else {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    private TreeNode tree;

    public TreeSolver(Board board) {
        this.board = board;

        List<TreeNode> rootChildren = new ArrayList<TreeNode>(board.letters.length);
        for (Board.Letter letter : board.letters) {
            rootChildren.add(new TreeNode(this, letter.location, letter));
        }
        this.tree = new TreeNode(this, rootChildren);
    }

    public boolean containsWord(String word) {
        ArrayList<String> letters = new ArrayList<String>(word.length());
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'q' && i + 1 < word.length() && word.charAt(i + 1) == 'u') {
                letters.add("qu");
                i++;
            } else {
                letters.add(String.valueOf(word.charAt(i)));
            }
        }

        return this.tree.search(letters, 0);
    }
}
