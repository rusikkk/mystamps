--
-- Auto-generated by Maven, based on values from src/main/resources/test/spring/test-data.properties
--

INSERT INTO users(id, login, role, name, registered_at, activated_at, hash, salt, email) VALUES
	(2, '@valid_admin_login@', 'ADMIN', 'Site Admin', NOW(), NOW(), '@old_valid_admin_password_hash@', '@old_valid_admin_password_salt@', 'admin@localhost');
