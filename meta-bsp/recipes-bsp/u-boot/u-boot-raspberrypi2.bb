require ${COREBASE}/meta/recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=0507cd7da8e7ad6d6701926ec9b84c95"

UBOOT_LOCALVERSION = "-venus"
UBOOT_ENV = "uEnv"

SRC_URI += " \
	file://uEnv.txt \
    file://config.txt \
"

# This revision corresponds to the tag "v2015.07"
# We use the revision in order to avoid having to fetch it from the
# repo during parse
SRCREV = "33711bdd4a4dce942fb5ae85a68899a8357bdd94"

PV = "v2015.07+git${SRCPV}"

EXTRA_OEMAKE_append = " KCFLAGS=-fgnu89-inline"

SRC_URI[md5sum] = "58c92bf2c46dc82f1b57817f09ca8bd8"
SRC_URI[sha256sum] = "37f7ffc75ec3c38ea3125350cc606d3ceac071ab68811c9fb0cfc25d70592e22"

# Install required file for Raspberry Pi bootloader, to indicate that it should
# load u-boot.
do_deploy_append() {
    install ${WORKDIR}/config.txt ${DEPLOYDIR}/config.txt
    ${S}/tools/mkenvimage -s 16384 -o ${DEPLOYDIR}/uboot.env ${WORKDIR}/uEnv.txt
}
