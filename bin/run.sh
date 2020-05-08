#!/bin/sh

export SRC="$(pwd)"

cd "$(dirname "$0")/../docker"

make PROJECT_DIR="$1" run
