ace.define("ace/snippets/hive",["require","exports","module"],function(e,t,n){"use strict";t.snippetText="snippet tbl\n	create table ${1:table} (\n		${2:columns}\n	);\nsnippet s*\n	select * from ${1:table}\n",t.scope="hive"})