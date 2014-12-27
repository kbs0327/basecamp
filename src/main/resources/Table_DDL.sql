CREATE TABLE [entities] (
	[eno] INTEGER AUTO_INCREMENT(1, 1) NOT NULL,
	[email] CHARACTER VARYING (255) NOT NULL,
	[password] CHARACTER VARYING (255) NOT NULL,
	[body] CHARACTER VARYING (40960),
	[write_time] DATETIME NOT NULL,
	CONSTRAINT [pk] PRIMARY KEY([eno])
)
REUSE_OID,
COLLATE utf8_bin