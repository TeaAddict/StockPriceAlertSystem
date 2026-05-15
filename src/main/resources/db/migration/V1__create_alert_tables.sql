CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255),

    CONSTRAINT chk_user_role CHECK (role IN ('ADMIN', 'USER'))
);


CREATE TABLE alert_rule (
    id BIGSERIAL PRIMARY KEY,
    ticker VARCHAR(20) NOT NULL,
    price_condition VARCHAR(50) NOT NULL,
    target_price DECIMAL(19, 4) NOT NULL,
    status VARCHAR(50) NOT NULL,
    triggered_at TIMESTAMPTZ NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255),

    CONSTRAINT fk_alert_rule_user FOREIGN KEY (user_id) REFERENCES users(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_alert_rule_user_id ON alert_rule(user_id);
CREATE INDEX idx_alert_rule_ticker ON alert_rule(ticker);


CREATE TABLE alert_event (
    id BIGSERIAL PRIMARY KEY,
    price DECIMAL(19, 4) NOT NULL,
    triggered_at TIMESTAMPTZ,
    alert_rule_id BIGINT NOT NULL,
    created_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP NOT NULL,
    created_by VARCHAR(255) NOT NULL,
    updated_by VARCHAR(255),

    CONSTRAINT fk_alert_event_rule FOREIGN KEY (alert_rule_id)
        REFERENCES alert_rule(id) ON DELETE CASCADE
);

CREATE INDEX idx_alert_event_rule_id ON alert_event(alert_rule_id);


