

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


