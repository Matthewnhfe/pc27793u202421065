package com.medisupply.platform.u202421065.shared.infrastructure.persistence.jpa.configuration.strategy;


import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;


public class SnakeCaseWithPluralizedTablePhysicalNamingStrategy implements PhysicalNamingStrategy {
    @Override
    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return null;
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return this.toSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return this.toSnakeCase(this.toPlural(identifier));
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return this.toSnakeCase(identifier);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return this.toSnakeCase(identifier);
    }

    private Identifier toSnakeCase(final Identifier identifier) {
        if (identifier == null) {
            return null;
        }
        final String regex = "([a-z])([A-Z])";
        final String replacement = "$1_$2";
        final String newName = identifier.getText()
                .replaceAll(regex, replacement)
                .toLowerCase();
        return Identifier.toIdentifier(newName);
    }

    private Identifier toPlural(final Identifier identifier) {
        if (identifier == null) {
            return null;
        }

        final String text = identifier.getText();
        final String lowerText = text.toLowerCase();
        final String newName;

        if (lowerText.endsWith("s") || lowerText.endsWith("x")
                || lowerText.endsWith("z") || lowerText.endsWith("ch")
                || lowerText.endsWith("sh")) {
            newName = text + "es";
        } else if (lowerText.endsWith("y")
                && lowerText.length() > 1
                && !"aeiou".contains(lowerText.substring(lowerText.length() - 2, lowerText.length() - 1))) {
            newName = text.substring(0, text.length() - 1) + "ies";
        } else {
            newName = text + "s";
        }

        return Identifier.toIdentifier(newName);
    }
}
