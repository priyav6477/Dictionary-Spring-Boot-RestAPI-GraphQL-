package com.dictionary.exception;

import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;

@Component
public class CustomExceptionResolver extends DataFetcherExceptionResolverAdapter {

	@Override
	protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
		if (ex instanceof WordNotFoundException) {
			return GraphqlErrorBuilder.newError().errorType(ErrorType.DataFetchingException).message(ex.getMessage())
					.path(env.getExecutionStepInfo().getPath()).location(env.getField().getSourceLocation()).build();
		} else if (ex instanceof WordAlreadyExistsException) {
			return GraphqlErrorBuilder.newError().errorType(ErrorType.ValidationError).message(ex.getMessage())
					.path(env.getExecutionStepInfo().getPath()).location(env.getField().getSourceLocation()).build();
		} else {
			return null;
		}
	}

}
