package be.dhofief.farmwatchbackend.grapqhl;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * A proposed Date scalar, that stores dates in String, formatted as: YYYY-MM-DD<BR/>
 * This Scalar is proposed to be used, for integration testing (checks that the plugin correctly manages Custom Scalars,
 * see samples) and with more documentation to help people to create their own Custom Scalar implementations.
 *
 * @author etienne-sf
 */
public class ISODate {

    /** Logger for this class */
    private static Logger logger = LoggerFactory.getLogger(ISODate.class);

    /** Custom Scalar for Date management. It serializes dates in String, formatted as: YYYY-MM-DD */
    public static GraphQLScalarType ISO8601DateTime = GraphQLScalarType.newScalar().name("ISO8601DateTime")
            .description("ISO 8601 time representation")
            .coercing( //
                    // Note: String is the way the data is stored in GraphQL queries
                    // Date is the type while in the java code, either in the client and in the server
                    new Coercing<LocalDate, String>() {

                        /**
                         * The date pattern, used when exchanging date with this {@link GraphQLScalarType} from and to
                         * the GrahQL Server
                         */
                        private final DateTimeFormatter format = DateTimeFormatter.ISO_INSTANT;

                        /**
                         * Called to convert a Java object result of a DataFetcher to a valid runtime value for the
                         * scalar type. <br/>
                         * Note : Throw {@link graphql.schema.CoercingSerializeException} if there is fundamental
                         * problem during serialisation, don't return null to indicate failure. <br/>
                         * Note : You should not allow {@link java.lang.RuntimeException}s to come out of your serialize
                         * method, but rather catch them and fire them as
                         * {@link graphql.schema.CoercingSerializeException} instead as per the method contract.
                         *
                         * @param dataFetcherResult
                         *            is never null
                         *
                         * @return a serialized value which may be null.
                         *
                         * @throws graphql.schema.CoercingSerializeException
                         *             if value input can't be serialized
                         */
                        @Override
                        public String serialize(Object input) throws CoercingSerializeException {
                            if (!(input instanceof LocalDate)) {
                                throw new CoercingSerializeException("Can't parse the '" + input.toString()
                                        + "' Date to a String (it should be a Date but is a "
                                        + input.getClass().getName() + ")");
                            } else {
                                return ((LocalDate) input).format(format);
                            }
                        }

                        /**
                         * Called to resolve an input from a query variable into a Java object acceptable for the scalar
                         * type. <br/>
                         * Note : You should not allow {@link java.lang.RuntimeException}s to come out of your
                         * parseValue method, but rather catch them and fire them as
                         * {@link graphql.schema.CoercingParseValueException} instead as per the method contract.
                         *
                         * @param input
                         *            is never null
                         *
                         * @return a parsed value which is never null
                         *
                         * @throws graphql.schema.CoercingParseValueException
                         *             if value input can't be parsed
                         */
                        @Override
                        public LocalDate parseValue(Object o) throws CoercingParseValueException {
                            if (!(o instanceof String)) {
                                throw new CoercingParseValueException("Can't parse the '" + o.toString()
                                        + "' string to a Date (it should be a String but is a " + o.getClass().getName()
                                        + ")");
                            } else {
                                try {
                                    return LocalDate.parse((String) o, format);
                                } catch (DateTimeParseException e) {
                                    throw new CoercingParseValueException(e.getMessage(), e);
                                }
                            }
                        }

                        /**
                         * Called during query validation to convert a query input AST node into a Java object
                         * acceptable for the scalar type. The input object will be an instance of
                         * {@link graphql.language.Value}. <br/>
                         * Note : You should not allow {@link java.lang.RuntimeException}s to come out of your
                         * parseLiteral method, but rather catch them and fire them as
                         * {@link graphql.schema.CoercingParseLiteralException} instead as per the method contract.
                         *
                         * @param input
                         *            is never null
                         *
                         * @return a parsed value which is never null
                         *
                         * @throws graphql.schema.CoercingParseLiteralException
                         *             if input literal can't be parsed
                         */
                        @Override
                        public LocalDate parseLiteral(Object o) throws CoercingParseLiteralException {
                            String val = null;
                            // o is an AST, that is: an instance of a class that implements graphql.language.Value
                            if (!(o instanceof StringValue)) {
                                throw new CoercingParseValueException("Can't parse the '" + o.toString()
                                        + "' string value to a Date (it should be a StringValue but is a "
                                        + o.getClass().getName() + ")");
                            } else {
                                try {
                                    val = ((StringValue) o).getValue();
                                    logger.trace("Parsing date from this literal: '{}'", val);
                                    return LocalDate.parse(val, format);

                                } catch (DateTimeParseException e) {
                                    throw new CoercingParseValueException(
                                            e.getMessage() + " when trying to parse '" + val + "'", e);
                                }
                            }
                        }
                    })
            .build();

}