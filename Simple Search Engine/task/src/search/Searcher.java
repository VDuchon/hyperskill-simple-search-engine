package search;

public class Searcher {
    private SearchStrategy searchStrategy;

    public Searcher(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void search(String query, Contacts contacts) {
        this.searchStrategy.search(query, contacts);
    }

    public static Searcher getSearcher(String stretegyType) {
        switch (stretegyType) {
            case "ALL":
                return new Searcher(new AllSearch());
            case "ANY":
                return new Searcher(new AnySearch());
            case "NONE":
                return new Searcher(new NoneSearch());
            default:
                return null;
        }
    }
}
