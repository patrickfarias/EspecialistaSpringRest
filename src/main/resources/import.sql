insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into estado (id, nome) values (1, 'Minas Gerais');
insert into estado (id, nome) values (2, 'Sao Paulo');
insert into estado (id, nome) values (3, 'Rio de Janeiro');
insert into estado (id, nome) values (4, 'Espirito Santo');

insert into cidade (id, nome, estado_id) values (1, 'Uberlandia', 1);
insert into cidade (id, nome, estado_id) values (2, 'Araguari', 1);

insert into forma_pagamento (id, descricao) values (1, 'Dinheiro');

insert into permissao (id, nome, descricao) values (1, 'Supervisor', 'Acessao todo o sistema' );


insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id) values ('Thai Gourmet', 10, 1, 1);
insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id ) values ('Thai Delivery', 9.50, 1, 1);
insert into restaurante (nome, taxa_frete, cozinha_id, forma_pagamento_id) values ('Tuk Tuk Comida Indiana', 15, 2, 1);


