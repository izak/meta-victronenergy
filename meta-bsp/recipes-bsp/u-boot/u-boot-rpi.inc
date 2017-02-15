require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=a2c678cfd4a4d97135585cad908541c6"

UBOOT_LOCALVERSION = "-venus"
UBOOT_ENV = "uEnv"

# This revision corresponds to the tag "v2016.11-rc3"
# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "d8bdfc80da39211d95f10d24e79f2e867305f71b"

PV = "v2016.11-rc3"

EXTRA_OEMAKE_append = " KCFLAGS=-fgnu89-inline"

SRC_URI[md5sum] = "58c92bf2c46dc82f1b57817f09ca8bd8"
SRC_URI[sha256sum] = "37f7ffc75ec3c38ea3125350cc606d3ceac071ab68811c9fb0cfc25d70592e22"
