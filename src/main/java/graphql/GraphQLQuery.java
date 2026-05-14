package graphql;

public interface GraphQLQuery<T> {
  String buildQuery();

  T parseResponse(String json);
}
