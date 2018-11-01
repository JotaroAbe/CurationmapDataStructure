# CurationmapDataStructure
## はじめに
このリポジトリは、[キュレーションマップシステム](https://github.com/JotaroAbe/CurationmapGenerator)の一部です。
## Json Data Structure
### CurationMap
|key|type|content|
|---|---|---|
|query|string|入力されたクエリ|
|documents|array|Documentの配列|
### Document
|key|type|content|
|---|---|---|
|url|string|Data Source|
|docNum|number|Document Number|
|hub|number|Hub値|
|auth|number|Authority値|
|fragments|array|Fragmentの配列|
|uuid|string|UUID|
### Fragment
|key|type|content|
|---|---|---|
|text|string|本文|
|links|array|Linkの配列|
|uuid|string|UUID|
### Link
|key|type|content|
|---|---|---|
|destDocNum|number|リンク先のDocument Number|
|uuid|string|リンク先のUUID|
## DataBase, Library, Format
- [MongoDB](https://www.mongodb.com/)
- [Morphia](https://mongodb.github.io/morphia/)
- Json