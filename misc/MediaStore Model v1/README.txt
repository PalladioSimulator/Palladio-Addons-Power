Originalversion aus Praktikum portiert auf PCM stable 3.5.0
Migration done at 5542


Files checked after migration:

Not Tested:
mediastore-many-servers.allocation (resenv broken)

Valid:
mediastore.repository
mediastore.system
mediastore.usagemodel
mediastore.resourceenvironment
mediastore.allocation
download_only.usagemodel
mediastore-open.usagemodel
mediastore-three-servers.allocation
mediastore-three-servers.resourceenvironment

Broken:
mediastore-many-servers.resourceenvironment (UnresolvedReference ProcSharing (didn't try to fix))
