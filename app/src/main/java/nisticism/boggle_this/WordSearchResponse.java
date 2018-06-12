package nisticism.boggle_this;
public class WordSearchResponse {
    public boolean isWord;
    public boolean isPrefix;

    public WordSearchResponse(boolean isWord, boolean isPrefix) {
        this.isWord = isWord;
        this.isPrefix = isPrefix;
    }
}
