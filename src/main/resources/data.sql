-- Insertar permisos
INSERT INTO permissions (id, name) VALUES (1, 'CREATE');
INSERT INTO permissions (id, name) VALUES (2, 'READ');
INSERT INTO permissions (id, name) VALUES (3, 'UPDATE');
INSERT INTO permissions (id, name) VALUES (4, 'DELETE');
INSERT INTO permissions (id, name) VALUES (5, 'REFACTOR');

-- Insertar roles
INSERT INTO roles (id, role_name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, role_name) VALUES (2, 'USER');
INSERT INTO roles (id, role_name) VALUES (3, 'INVITED');
INSERT INTO roles (id, role_name) VALUES (4, 'DEVELOPER');

-- Relacionar roles con permisos
-- ADMIN: CREATE, READ, UPDATE, DELETE
INSERT INTO role_permissions (role_id, permission_id) VALUES (1, 1);
INSERT INTO role_permissions (role_id, permission_id) VALUES (1, 2);
INSERT INTO role_permissions (role_id, permission_id) VALUES (1, 3);
INSERT INTO role_permissions (role_id, permission_id) VALUES (1, 4);

-- USER: CREATE, READ
INSERT INTO role_permissions (role_id, permission_id) VALUES (2, 1);
INSERT INTO role_permissions (role_id, permission_id) VALUES (2, 2);

-- INVITED: READ
INSERT INTO role_permissions (role_id, permission_id) VALUES (3, 2);

-- DEVELOPER: CREATE, READ, UPDATE, DELETE, REFACTOR
INSERT INTO role_permissions (role_id, permission_id) VALUES (4, 1);
INSERT INTO role_permissions (role_id, permission_id) VALUES (4, 2);
INSERT INTO role_permissions (role_id, permission_id) VALUES (4, 3);
INSERT INTO role_permissions (role_id, permission_id) VALUES (4, 4);
INSERT INTO role_permissions (role_id, permission_id) VALUES (4, 5);
