package mobile.search;

public class CaseInsensitiveFilter <T, V extends Comparable<V>> implements Filter<T> {
    private final String valueToFind;
    private final FieldExtractor<T, String> fieldExtractor;

    public CaseInsensitiveFilter(String valueToFind, FieldExtractor<T, String> fieldExtractor) {
        this.valueToFind = valueToFind;
        this.fieldExtractor = fieldExtractor;
    }

    @Override
    public boolean matches(T item) {
        String value = fieldExtractor.extractValue(item);
        return value.matches(valueToFind);
    }
}
